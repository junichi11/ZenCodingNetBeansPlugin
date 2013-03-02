package org.lorenzos.emmet.actions;

import java.util.List;
import org.openide.cookies.EditorCookie;

public final class EmmetSelectNextItem extends EmmetAbstractAction {

	public EmmetSelectNextItem(List<EditorCookie> context) {
		super(context, "select_next_item");
	}

}
