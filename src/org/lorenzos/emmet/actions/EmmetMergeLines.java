
package org.lorenzos.emmet.actions;

import java.util.List;
import org.openide.cookies.EditorCookie;

public final class EmmetMergeLines extends EmmetAbstractAction {

	public EmmetMergeLines(List<EditorCookie> context) {
		super(context, "merge_lines");
	}

}
