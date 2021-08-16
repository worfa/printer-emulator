package demidovTestProject.test.project.model;

public class DocTypePDF extends AbstractDocument {

	public DocTypePDF() {
		setNameTypeDoc(TypeDoc.PDF);
		setPaperSize(TypeSizePaper.A0);
		setPrintTime(0.5);
	}
}
