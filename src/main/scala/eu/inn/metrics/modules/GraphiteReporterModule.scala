package eu.inn.metrics.modules

import eu.inn.metrics.loaders.{GraphiteReporterLoader, MetricsReporterLoader}

class GraphiteReporterModule(prefix: String) extends MetricsModule(prefix) {
  bind [MetricsReporterLoader] to injected[GraphiteReporterLoader]
}
