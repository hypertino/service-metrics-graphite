import com.typesafe.config.{Config, ConfigFactory}
import eu.inn.metrics.loaders.MetricsReporterLoader
import eu.inn.metrics.modules.GraphiteReporterModule
import eu.inn.metrics.{Metrics, ProcessMetrics}

import scala.io.StdIn

object TestMain extends GraphiteReporterModule {
  bind [Config] to ConfigFactory.load()

  def main(args: Array[String]): Unit = {
    ProcessMetrics.startReporting(inject[Metrics])
    val reporterLoader = inject[MetricsReporterLoader]
    var break = false
    reporterLoader.run()
    while(!break) {
      break = StdIn.readLine() == "quit"
    }
  }
}

