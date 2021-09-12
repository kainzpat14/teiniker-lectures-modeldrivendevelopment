package at.fhj.mdd.ss2020.generator;

import at.fhj.mdd.ss2020.metamodel.MField;
import at.fhj.mdd.ss2020.metamodel.MIntField;
import at.fhj.mdd.ss2020.metamodel.MStringField;
import at.fhj.mdd.ss2020.metamodel.MTelegram;
import at.fhj.mdd.ss2020.metamodel.MTelegrams;

public interface TelegramVisitor {
	void visit(MTelegrams telegrams);

	void visit(MTelegram telegram);

	void visit(MField field);

	void visit(MIntField field);

	void visit(MStringField field);
}
