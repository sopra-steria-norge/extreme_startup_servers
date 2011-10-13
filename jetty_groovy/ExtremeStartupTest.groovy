#!/usr/bin/env groovy

class ExtremeStartupTest extends GroovyTestCase {
  void testRootGet() {
    def url = new URL("http://localhost:8080/")
    assert url.text =~ /Hello/
  }
}