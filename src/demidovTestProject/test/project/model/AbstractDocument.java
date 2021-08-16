package demidovTestProject.test.project.model;

public abstract class AbstractDocument {

	private double printTime;
	private TypeDoc nameTypeDoc;
	private TypeSizePaper paperSize;
	
	public AbstractDocument() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameTypeDoc == null) ? 0 : nameTypeDoc.hashCode());
		result = prime * result + ((paperSize == null) ? 0 : paperSize.hashCode());
		long temp;
		temp = Double.doubleToLongBits(printTime);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractDocument other = (AbstractDocument) obj;
		if (nameTypeDoc != other.nameTypeDoc)
			return false;
		if (paperSize != other.paperSize)
			return false;
		if (Double.doubleToLongBits(printTime) != Double.doubleToLongBits(other.printTime))
			return false;
		return true;
	}



	public double getPrintTime() {
		return printTime;
	}

	protected void setPrintTime(double printTime) {
		this.printTime = printTime;
	}

	public TypeDoc getNameTypeDoc() {
		return nameTypeDoc;
	}

	public void setNameTypeDoc(TypeDoc nameTypeDoc) {
		this.nameTypeDoc = nameTypeDoc;
	}

	public TypeSizePaper getPaperSize() {
		return paperSize;
	}

	public void setPaperSize(TypeSizePaper paperSize) {
		this.paperSize = paperSize;
	}

	@Override
	public String toString() {
		return "Document [printTime=" + printTime + ", nameTypeDoc=" + nameTypeDoc + ", paperSize=" + paperSize
				+ "]";
	}
}
