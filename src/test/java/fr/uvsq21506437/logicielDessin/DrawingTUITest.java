package fr.uvsq21506437.logicielDessin;

import Command.DrawingTUI;
import junit.framework.TestCase;

public class DrawingTUITest extends TestCase{
	/**
	 * test main
	 * */
	public void testCmd() {
		DrawingTUI d = new DrawingTUI();
		d.nextCommand();
	}

}
