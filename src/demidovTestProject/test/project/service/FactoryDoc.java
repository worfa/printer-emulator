package demidovTestProject.test.project.service;

import demidovTestProject.test.project.model.AbstractDocument;
import demidovTestProject.test.project.model.DocTypeCSV;
import demidovTestProject.test.project.model.DocTypePDF;
import demidovTestProject.test.project.model.DocTypeTXT;
import demidovTestProject.test.project.model.TypeDoc;

public class FactoryDoc {

	public AbstractDocument createDocument(TypeDoc type) {
		
		AbstractDocument doc = null;

        switch (type) {
            case TXT:
                doc =  new DocTypeTXT();
                break;
            case PDF:
                doc = new DocTypePDF();
                break;
            case CSV:
                doc =  new DocTypeCSV();
                break;
        }

        return doc;
		
	}
	
}
