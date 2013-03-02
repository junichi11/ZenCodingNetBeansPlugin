
package org.lorenzos.emmet.actions;

import java.util.List;
import org.openide.cookies.EditorCookie;

public final class EmmetMatchPair extends EmmetAbstractAction {

	public EmmetMatchPair(List<EditorCookie> context) {
		super(context, "match_pair");
	}

}
