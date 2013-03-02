package org.lorenzos.emmet.actions;

import java.util.List;
import org.openide.cookies.EditorCookie;

public final class EmmetGoToMatchingPair extends EmmetAbstractAction {

	public EmmetGoToMatchingPair(List<EditorCookie> context) {
		super(context, "matching_pair");
	}

}
