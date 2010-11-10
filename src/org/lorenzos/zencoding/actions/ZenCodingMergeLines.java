/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lorenzos.zencoding.actions;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import org.lorenzos.utils.OutputUtils;
import org.lorenzos.zencoding.zeneditor.ZenEditor;
import org.openide.cookies.EditorCookie;
import ru.zencoding.JSExecutor;

public final class ZenCodingMergeLines implements ActionListener {

	private final List<EditorCookie> context;

	public ZenCodingMergeLines(List<EditorCookie> context) {
		this.context = context;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		ArrayList<Integer> editorCookieDone = new ArrayList<Integer>();
		for (EditorCookie editorCookie : this.context) {
			if (editorCookieDone.contains(editorCookie.hashCode())) continue;
			editorCookieDone.add(editorCookie.hashCode());
			try {
				JSExecutor jsRunner = JSExecutor.getSingleton();
				ZenEditor editor = ZenEditor.create(editorCookie);
				jsRunner.runAction(editor, "merge_lines");
				editor.restoreInitialScrollingPosition();
			} catch (Exception ex) {
				ex.printStackTrace(OutputUtils.getErrorStream());
			}
		}
	}
}