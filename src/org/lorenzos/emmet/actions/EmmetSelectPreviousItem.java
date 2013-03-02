package org.lorenzos.emmet.actions;

import java.util.List;
import org.openide.cookies.EditorCookie;

public final class EmmetSelectPreviousItem extends EmmetAbstractAction {

	public EmmetSelectPreviousItem(List<EditorCookie> context) {
		super(context, "select_previous_item");
	}

}
