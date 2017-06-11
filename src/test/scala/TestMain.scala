import com.hypertino.metrics.loaders.MetricsReporterLoader
import com.hypertino.metrics.{MetricsTracker, ProcessMetrics}
import com.hypertino.metrics.modules.GraphiteReporterModule
import com.typesafe.config.{Config, ConfigFactory}

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

