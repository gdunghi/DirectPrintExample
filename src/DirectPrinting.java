
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class DirectPrinting {

	public static void main(String[] args) {
		PrinterJob pj = PrinterJob.getPrinterJob();
		pj.setPrintable(new Printer(), getPageFormat(pj));
		try {
			pj.print();

		} catch (PrinterException ex) {
			ex.printStackTrace();
		}

	}

	public static PageFormat getPageFormat(PrinterJob pj) {

		PageFormat pf = pj.defaultPage();
		Paper paper = pf.getPaper();

		double middleHeight = 8.0;
		double headerHeight = 2.0;
		double footerHeight = 2.0;
		double width = convert_CM_To_PPI(8); // printer know only point per
												// inch.default value is 72ppi
		double height = convert_CM_To_PPI(headerHeight + middleHeight + footerHeight);
		paper.setSize(width, height);
		paper.setImageableArea(0, 10, width, height - convert_CM_To_PPI(1)); // define
																				// boarder
																				// size
																				// after
																				// that
																				// print
																				// area
																				// width
																				// is
																				// about
																				// 180
																				// points

		pf.setOrientation(PageFormat.PORTRAIT); // select orientation portrait
												// or landscape but for this
												// time portrait
		pf.setPaper(paper);

		return pf;
	}

	protected static double convert_CM_To_PPI(double cm) {
		return toPPI(cm * 0.393600787);
	}

	protected static double toPPI(double inch) {
		return inch * 72d;
	}

}
