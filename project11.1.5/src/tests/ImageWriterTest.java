package tests;

import static org.junit.Assert.assertTrue;
import java.awt.Color;
import org.junit.jupiter.api.Test;
import renderer.ImageWriter;

public class ImageWriterTest
{
	@Test
	void ImageWriterTest1()
	{
		ImageWriter image=new ImageWriter("test1",500,500,500,500);
		for(int i=0;i<500;i++)
			for(int j=0;j<500;j++)
			{
				if(i%50==0||j%50==0)
					image.writePixel(i, j, Color.blue);
				else
					image.writePixel(i, j, Color.white);
			}
		image.writeToimage();
		assertTrue(true);
	}
	@Test
	void ImageWriterTest2()
	{
		ImageWriter image=new ImageWriter("test2",500,500,500,500);
		for(int i=0;i<500;i++)
			for(int j=0;j<500;j++)
			{
				if(j<=100)
					image.writePixel(i, j, Color.blue);
				else
					if(j>=400)
						image.writePixel(i, j, Color.green);
					else
						if((j>=300&&j<=400)&&(i>=200&&i<=250))
								image.writePixel(i, j, Color.black);
						else
							if(j>250&&(i>=100&&i<=350))
								image.writePixel(i, j, Color.orange);
							else
								if((j>125&&j<=250)&&(i>=100&&i<=225))
								{
									if(i>(-j+350))
										image.writePixel(i, j, Color.red);
									else
										image.writePixel(i, j, Color.white);
								}
								else
									if((j>125&&j<=250)&&(i>=225&&i<=350))
									{
										if(i<j+100)
											image.writePixel(i, j, Color.red);
										else
											image.writePixel(i, j, Color.white);
									}
									else
										image.writePixel(i, j, Color.white);
							
				
			}
		image.writeToimage();
		assertTrue(true);
	}

	@Test
	void ImageWriterTest3()
	{
		ImageWriter image=new ImageWriter("test3",500,500,500,500);
		for(int i=0;i<500;i++)
			for(int j=0;j<500;j++)
			{
				if((j>=200&&j<=400)&&(i>=200&&i<=250))
					image.writePixel(i, j,20,160,230);
				else
					if((j>=125&&j<=250)&&(i>=100&&i<=225))
					{
						if(i>=(-j+350))
							image.writePixel(i, j,20,160,230);
						else
							image.writePixel(i, j, Color.white);
					}
					else
						if((j>=125&&j<=250)&&(i>=225&&i<=350))
						{
							if(i<=j+100)
								image.writePixel(i, j,20,160,230);
							else
								image.writePixel(i, j, Color.white);
						}
						else
							image.writePixel(i, j, Color.white);
			}
		image.writeToimage();
		assertTrue(true);
	}
}
