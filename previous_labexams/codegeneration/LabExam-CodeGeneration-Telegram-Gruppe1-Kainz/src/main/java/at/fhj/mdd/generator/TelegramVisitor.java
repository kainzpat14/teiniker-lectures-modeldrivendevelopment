package at.fhj.mdd.generator;

import at.fhj.mdd.metamodel.MField;
import at.fhj.mdd.metamodel.MIntField;
import at.fhj.mdd.metamodel.MStringField;
import at.fhj.mdd.metamodel.MTelegram;
import at.fhj.mdd.metamodel.MTelegrams;

public interface TelegramVisitor {
	void visit(MTelegrams telegrams);

	void visit(MTelegram telegram);

	void visit(MField field);

	void visit(MIntField field);

	void visit(MStringField field);
}
