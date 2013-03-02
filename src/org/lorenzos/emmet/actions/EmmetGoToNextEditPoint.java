
package org.lorenzos.emmet.actions;

import java.util.List;
import org.openide.cookies.EditorCookie;

public final class EmmetGoToNextEditPoint extends EmmetAbstractAction {

	public EmmetGoToNextEditPoint(List<EditorCookie> context) {
		super(context, "next_edit_point");
	}

}
