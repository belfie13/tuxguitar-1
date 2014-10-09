/*
 * Created on 02-dic-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.herac.tuxguitar.app.items.tool;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.herac.tuxguitar.app.TuxGuitar;
import org.herac.tuxguitar.app.action.TGActionProcessor;
import org.herac.tuxguitar.app.action.impl.view.ShowFretBoardAction;
import org.herac.tuxguitar.app.action.impl.view.ShowInstrumentsAction;
import org.herac.tuxguitar.app.action.impl.view.ShowTransportAction;
import org.herac.tuxguitar.app.items.ToolItems;

/**
 * @author julian
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ViewToolItems extends ToolItems{
	public static final String NAME = "view.items";
	
	private ToolItem showFretBoard;
	private ToolItem showInstruments;
	private ToolItem showTransport;
	
	public ViewToolItems(){
		super(NAME);
	}
	
	public void showItems(ToolBar toolBar){
		//--FRETBOARD--
		this.showFretBoard = new ToolItem(toolBar, SWT.CHECK);
		this.showFretBoard.addSelectionListener(new TGActionProcessor(ShowFretBoardAction.NAME));
		
		//--INSTRUMENTS--
		this.showInstruments = new ToolItem(toolBar, SWT.CHECK);
		this.showInstruments.addSelectionListener(new TGActionProcessor(ShowInstrumentsAction.NAME));
		
		//--TRANSPORT--
		this.showTransport = new ToolItem(toolBar, SWT.CHECK);
		this.showTransport.addSelectionListener(new TGActionProcessor(ShowTransportAction.NAME));
		
		this.loadIcons();
		this.loadProperties();
	}
	
	public void update(){
		this.showFretBoard.setSelection(TuxGuitar.getInstance().getFretBoardEditor().isVisible());
		this.showInstruments.setSelection(!TuxGuitar.getInstance().getChannelManager().isDisposed());
		this.showTransport.setSelection(!TuxGuitar.getInstance().getTransport().isDisposed());
	}
	
	public void loadProperties(){
		this.showFretBoard.setToolTipText(TuxGuitar.getProperty("view.show-fretboard"));
		this.showInstruments.setToolTipText(TuxGuitar.getProperty("view.show-instruments"));
		this.showTransport.setToolTipText(TuxGuitar.getProperty("view.show-transport"));
	}
	
	public void loadIcons(){
		this.showFretBoard.setImage(TuxGuitar.getInstance().getIconManager().getFretboard());
		this.showInstruments.setImage(TuxGuitar.getInstance().getIconManager().getInstruments());
		this.showTransport.setImage(TuxGuitar.getInstance().getIconManager().getTransport());
	}
}
