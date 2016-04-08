package eu.inn.metrics.modules

import eu.inn.metrics.loaders.{GraphiteReporterLoader, MetricsReporterLoader}

class GraphiteReporterModule extends MetricsModule {
  bind [MetricsReporterLoader] to injected[GraphiteReporterLoader]
}
