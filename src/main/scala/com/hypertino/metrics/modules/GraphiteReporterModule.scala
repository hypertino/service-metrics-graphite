package com.hypertino.metrics.modules

import com.hypertino.metrics.loaders.{GraphiteReporterLoader, MetricsReporterLoader}

class GraphiteReporterModule extends MetricsModule {
  bind [MetricsReporterLoader] to injected[GraphiteReporterLoader]
}
