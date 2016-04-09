import com.typesafe.config.{Config, ConfigFactory}
import eu.inn.metrics.loaders.MetricsReporterLoader
import eu.inn.metrics.modules.GraphiteReporterModule
import eu.inn.metrics.{MetricsTracker, ProcessMetrics}

import scala.io.StdIn

object TestMain extends GraphiteReporterModule {
  bind [Config] to ConfigFactory.load()

  def main(args: Array[String]): Unit = {
    ProcessMetrics.startReporting(inject[MetricsTracker])
    val reporterLoader = inject[MetricsReporterLoader]
    reporterLoader.run()
    var break = false
    while(!break) {
      break = StdIn.readLine() == "quit"
    }
  }
}

