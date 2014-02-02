package com.DCStudios.ProjectXXX.BackGround;

import com.DCStudios.ProjectXXX.DataStructures.Measure;
import com.DCStudios.ProjectXXX.Ground.Grass;
import com.badlogic.gdx.math.Vector2;

public class TestBackGround extends BackGround {

	@Override
	protected void setUpBackGround() {
		for (int i = 1; i < 21; i++)
			for (int k = 1; k < 11; k++)
				backGround.add(new Grass(new Vector2((i-1) * 10, (k-1) * 10), new Measure(10,10)));
	}

}
