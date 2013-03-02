
package org.lorenzos.emmet.actions;

import java.util.List;
import org.openide.cookies.EditorCookie;

public final class EmmetEvaluateMathExpression extends EmmetAbstractAction {

	public EmmetEvaluateMathExpression(List<EditorCookie> context) {
		super(context, "evaluate_math_expression");
	}

}
