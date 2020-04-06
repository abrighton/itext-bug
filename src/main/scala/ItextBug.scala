import java.io.{ByteArrayInputStream, FileOutputStream, OutputStream}
import java.nio.file.{Files, Paths}

import com.itextpdf.html2pdf.HtmlConverter
import com.itextpdf.kernel.geom.PageSize
import com.itextpdf.kernel.pdf.{PdfDocument, PdfWriter}

// Run this from the directory containing TEST.html
object ItextBug extends App {
  def saveAsPdf(out: OutputStream, html: String, orientation: String): Unit = {
    val pageSize = if (orientation == "landscape") PageSize.LETTER.rotate() else PageSize.LETTER
    val writer: PdfWriter = new PdfWriter(out)
    val document: PdfDocument = new PdfDocument(writer)
    document.setDefaultPageSize(pageSize)
    HtmlConverter.convertToPdf(new ByteArrayInputStream(html.getBytes()), document)
    out.close()
  }

  val html = new String(Files.readAllBytes(Paths.get("TEST.html")))
  val out = new FileOutputStream("TEST.pdf")

  // This version crashes
  saveAsPdf(out, html, "landscape")

  // This version works
//  saveAsPdf(out, html, Some("portrait"))
}

