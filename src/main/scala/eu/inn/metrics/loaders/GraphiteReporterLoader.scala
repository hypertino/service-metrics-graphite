package eu.inn.metrics.loaders

import java.net.InetAddress
import java.util.concurrent.TimeUnit

import com.codahale.metrics.MetricRegistry
import com.codahale.metrics.graphite.{Graphite, GraphiteReporter}
import com.typesafe.config.Config
import eu.inn.binders.tconfig._
import org.slf4j.LoggerFactory

import scala.concurrent.duration.Duration
import scala.util.Try

case class GraphiteOptions(enabled: Boolean,
                           host: String,
                           port: Int,
                           prefix: String,
                           hostSuffix: Option[String],
                           reportPeriod: Duration
                          )

class GraphiteReporterLoader(options: GraphiteOptions, registry: MetricRegistry) extends MetricsReporterLoader {
  val log = LoggerFactory.getLogger(getClass)
  def this(config: Config, registry: MetricRegistry) = this(config.getValue("graphite").read[GraphiteOptions], registry)

  def run() : Unit = {
    val prefix = Seq(options.prefix, Try{
      InetAddress.getLocalHost.getHostName
    } getOrElse {
      "unknown-host"
    }.replaceAll("\\.", "-") + options.hostSuffix.fold("")("-" + _)).filter(_.trim.nonEmpty).mkString(".")

    log.info(s"Starting graphite reporter / $options")

    val graphite = new Graphite(options.host, options.port)
    val reporter = GraphiteReporter.forRegistry(registry).prefixedWith(prefix).build(graphite)
    reporter.start(options.reportPeriod.toMillis, TimeUnit.MILLISECONDS)
  }
}
