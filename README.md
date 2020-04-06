# itext-bug
This project demonstrates an itext 7 bug that occurs when converting a generated HTML file [TEST.html](TEST.html) to PDF.
If I try to use landscape mode (pageSize = PageSize.LETTER.rotate())
in [src/main/scala/ItextBug.scala](src/main/scala/ItextBug.scala), I get the exception below.

To demonstrate the bug, you can run the script run.sh: (Note: Requires sbt and Java-11 or newer to be installed):

```
> run.sh
[info] Loading global plugins from /home/abrighto/.sbt/1.0/plugins
[info] Loading settings for project itext-bug-build from plugins.sbt ...
[info] Loading project definition from /shared/work/tmt/csw/itext-bug/project
[info] Loading settings for project itext-bug from build.sbt ...
[info] Set current project to Itext-Bug (in build file:/shared/work/tmt/csw/itext-bug/)
[info] Wrote /shared/work/tmt/csw/itext-bug/target/scala-2.13/itext-bug_2.13-0.1.0-SNAPSHOT.pom
[info] Main Scala API documentation to /shared/work/tmt/csw/itext-bug/target/scala-2.13/api...
model contains 2 documentable templates
[info] Main Scala API documentation successful.
[success] Total time: 2 s, completed Apr 6, 2020, 2:08:13 PM
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Exception in thread "main" java.lang.UnsupportedOperationException
        at com.itextpdf.layout.renderer.AreaBreakRenderer.draw(AreaBreakRenderer.java:83)
        at com.itextpdf.layout.renderer.AbstractRenderer.drawChildren(AbstractRenderer.java:855)
	at com.itextpdf.layout.renderer.BlockRenderer.draw(BlockRenderer.java:580)
	at com.itextpdf.layout.renderer.AbstractRenderer.drawChildren(AbstractRenderer.java:855)
	at com.itextpdf.layout.renderer.BlockRenderer.draw(BlockRenderer.java:580)
	at com.itextpdf.layout.renderer.DocumentRenderer.flushSingleRenderer(DocumentRenderer.java:147)
	at com.itextpdf.layout.renderer.RootRenderer.processRenderer(RootRenderer.java:380)
	at com.itextpdf.layout.renderer.RootRenderer.shrinkCurrentAreaAndProcessRenderer(RootRenderer.java:369)
	at com.itextpdf.html2pdf.attach.impl.layout.HtmlDocumentRenderer.shrinkCurrentAreaAndProcessRenderer(HtmlDocumentRenderer.java:347)
	at com.itextpdf.layout.renderer.RootRenderer.addChild(RootRenderer.java:264)
	at com.itextpdf.html2pdf.attach.impl.layout.HtmlDocumentRenderer.processWaitingElement(HtmlDocumentRenderer.java:234)
	at com.itextpdf.html2pdf.attach.impl.layout.HtmlDocumentRenderer.close(HtmlDocumentRenderer.java:194)
	at com.itextpdf.layout.Document.close(Document.java:135)
	at com.itextpdf.html2pdf.HtmlConverter.convertToPdf(HtmlConverter.java:261)
	at com.itextpdf.html2pdf.HtmlConverter.convertToPdf(HtmlConverter.java:221)
	at ItextBug$.saveAsPdf(ItextBug.scala:15)
	at ItextBug$.delayedEndpoint$ItextBug$1(ItextBug.scala:23)
	at ItextBug$delayedInit$body.apply(ItextBug.scala:9)
	at scala.Function0.apply$mcV$sp(Function0.scala:39)
	at scala.Function0.apply$mcV$sp$(Function0.scala:39)
	at scala.runtime.AbstractFunction0.apply$mcV$sp(AbstractFunction0.scala:17)
	at scala.App.$anonfun$main$1(App.scala:73)
	at scala.App.$anonfun$main$1$adapted(App.scala:73)
	at scala.collection.IterableOnceOps.foreach(IterableOnce.scala:553)
	at scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:551)
	at scala.collection.AbstractIterable.foreach(Iterable.scala:921)
	at scala.App.main(App.scala:73)
	at scala.App.main$(App.scala:71)
	at ItextBug$.main(ItextBug.scala:9)
	at ItextBug.main(ItextBug.scala)

```

If you change the "landscape" to "portrait" in [src/main/scala/ItextBug.scala](src/main/scala/ItextBug.scala), it works.
