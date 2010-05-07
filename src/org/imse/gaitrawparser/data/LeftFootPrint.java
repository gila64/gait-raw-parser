package org.imse.gaitrawparser.data;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Point;
import org.imse.gaitrawparser.data.PressurePoint.Foot;

public class LeftFootPrint extends FootPrint {

	public LeftFootPrint(int lenX, int lenY) {
		super(lenX, lenY);
	}

	@Override
	public Foot getFoot() {
		return Foot.Left;
	}

	@Override
	protected Line getInnerLine(Point p1, Point p2) {
		if (p1.y > p2.y) {
			return new Line(p1.x + 1, p1.y + 1, p2.x + 1, p2.y + 1);
		} else {
			return new Line(p1.x, p1.y + 1, p2.x, p2.y + 1);
		}
	}

	@Override
	protected boolean isInnerPoint(int x, int y) {
		if (y + 1 < lenY && pixel[x][y + 1] == false) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected double getTargetAngle() {
		return -0.1;
	}

	@Override
	protected boolean isOutside(double py, double yl, double yr) {
		if (yl < py + 1 || yr < py + 1) {
			return false;
		} else {
			return true;
		}
	}

	

}