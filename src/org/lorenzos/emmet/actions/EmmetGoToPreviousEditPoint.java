
package org.lorenzos.emmet.actions;

import java.util.List;
import org.openide.cookies.EditorCookie;

public final class EmmetGoToPreviousEditPoint extends EmmetAbstractAction {

	public EmmetGoToPreviousEditPoint(List<EditorCookie> context) {
		super(context, "prev_edit_point");
	}

}
