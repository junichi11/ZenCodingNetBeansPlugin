/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lorenzos.emmet.actions;

import io.emmet.actions.EmmetMenu;
import io.emmet.actions.AbstractMenuItem;
import io.emmet.actions.EmmetMenuAction;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.MenuElement;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.awt.DynamicMenuContent;
import org.openide.util.HelpCtx;
import org.openide.util.actions.CallableSystemAction;

/**
 *
 * @author Sergey
 */
@ActionID(id = "org.lorenzos.emmet.actions.ActionsFactory", category = "Emmet Basic")
@ActionRegistration(lazy = false, displayName = "Emmet Dyn")
@ActionReference(path = "Menu/Edit/Emmet Dyn", position = 2376)
public class ActionsFactory extends CallableSystemAction {

	@Override
	public void performAction() {
	}

	@Override
	public String getName() {
		return "Emmet Factory";
	}

	@Override
	public HelpCtx getHelpCtx() {
		return HelpCtx.DEFAULT_HELP;
	}

	@Override
	public JMenuItem getMenuPresenter() {
		JMenu menu = new EmmetDynamicMenu(getName());
		return menu;
	}

	class EmmetDynamicMenu extends JMenu implements DynamicMenuContent {

		private EmmetDynamicMenu(String name) {
			super(name);
			updateMenu();
		}

		@Override
		public JComponent[] getMenuPresenters() {
			return new JComponent[]{this};
		}

		@Override
		public JComponent[] synchMenuPresenters(JComponent[] jcs) {
			return getMenuPresenters();
		}

		private void updateMenu() {
			removeAll();
			
			System.out.println("Create menu");
			EmmetMenu rootMenu = EmmetMenu.create();
			for (AbstractMenuItem item : rootMenu.getItems()) {
				add((JMenuItem) createContributionItem(item));
			}
		}
		
		private MenuElement createContributionItem(AbstractMenuItem item) {
			if (item instanceof EmmetMenu)
				return createContributionItem((EmmetMenu) item);

			return createContributionItem((EmmetMenuAction) item);
		}

		private MenuElement createContributionItem(EmmetMenuAction item) {
			
			Action action = createAction(item.getId());
			action.putValue(Action.NAME, item.getId());
			
			JMenuItem menuItem = new JMenuItem(action);
			menuItem.setText(item.getName());
			return menuItem;
		}

		private MenuElement createContributionItem(EmmetMenu item) {
			JMenu menu = new JMenu(item.getName());
			for (AbstractMenuItem subitem : item.getItems()) {
				menu.add((JMenuItem) createContributionItem(subitem));
			}

			return menu;
		}

		private Action createAction(String actionCommand) {
			Action action = new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					menuItemActionPerformed(e);
				}
			};

			action.putValue(Action.ACTION_COMMAND_KEY, actionCommand);
			return action;
		}

		private void menuItemActionPerformed(ActionEvent evt) {
			String command = evt.getActionCommand();
			
			System.out.println("Performing " + command);
		}
	}	
}
