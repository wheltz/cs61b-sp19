public class NBody {
    public static double readRadius(String string) {
        In in = new In(string);
        in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String string) {
        In in = new In(string);
        int N = in.readInt();
        in.readDouble();
        Body[] bodies = new Body[N];
        for(int i = 0; i < N; i++) {
            bodies[i] = new Body(in.readDouble(), in.readDouble(),in.readDouble(), in.readDouble(),
                in.readDouble(),in.readString());
        }
        return bodies;
    }

    public static void main(String[] args) {
        double T  = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
		double time = 0;
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] bodies = readBodies(filename);
		int numOfbodies = bodies.length;
        StdDraw.setScale(-radius, radius);
		
		StdDraw.enableDoubleBuffering();
		double[] xForces = new double[numOfbodies];
		double[] yForces = new double[numOfbodies];
		while(time <= T){for(int i = 0; i<numOfbodies; i++){
			xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
			yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
		}
		for(int i = 0; i<numOfbodies; i++){
			bodies[i].update(dt,xForces[i],yForces[i]);
		}
		StdDraw.picture(0,0,"images/starfield.jpg");
		for(Body body : bodies) {
			body.draw();
		}
		StdDraw.show();
		StdDraw.pause(10);
		time += dt;
	}
	StdOut.printf("%d\n", bodies.length);
	StdOut.printf("%.2e\n", radius);
	for (int i = 0; i < bodies.length; i++) {
		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
					  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
	}
		
    }
	// public static void main(String[] args) {
    //     /**
    //      * Get data --finished
    //      */
    //     double T = Double.parseDouble(args[0]);
    //     double dt = Double.parseDouble(args[1]);
    //     String fileName = args[2];
    //     double uniRadius = NBody.readRadius(fileName);
    //     Body[] Planets = NBody.readBodies(fileName);
 
    //     /**
    //      * Draw the background
    //      */
    //     StdDraw.setScale(-uniRadius, uniRadius);
    //     StdDraw.clear();
    //     StdDraw.picture(0, 0, "images/starfield.jpg");
 
    //     /**
    //      * Draw planets 63 filename给到实例Planets
    //      */
    //     for (Body var : Planets) {
    //         var.draw();
    //     }
 
    //     /**
    //      * Animation 双缓冲
    //      */
    //     StdDraw.enableDoubleBuffering();
    //     /**
    //      * Set up a loop to loop until time variable reaches T
    //      * 最后一个部分了Creating an Animation
    //      *
    //      * For each time through the loop, do the following:
    //      * 1.Create an xForces array and yForces array.
    //      *
    //      * 2.Calculate the net x and y forces for each Body, storing these in the xForces and yForces arrays respectively.
    //      *
    //      * 3.After calculating the net forces for every Body, call update on each of the Bodys. This will update each body’s position,
    //      * velocity, and acceleration.
    //      *
    //      * 4.Draw the background image.
    //      *
    //      * 5.Draw all of the Bodys.
    //      *
    //      * 6.Show the offscreen buffer (see the show method of StdDraw).
    //      *
    //      * 7.Pause the animation for 10 milliseconds (see the pause method of StdDraw). You may need to tweak this on your computer.
    //      *
    //      * 8.Increase your time variable by dt.
    //      *
    //      *
    //      */
    //     for(double t=0;t<=T;t+=dt){
    //         //创造xForce和YForce数组
    //         double[] xForce=new double[Planets.length];
    //         double[] yForce=new double[Planets.length];
    //         //计算netForce
    //         for (int i=0;i<Planets.length;i++){
    //             xForce[i]=Planets[i].calcNetForceExertedByX(Planets);
    //             yForce[i]=Planets[i].calcNetForceExertedByY(Planets);
    //         }
    //         //更新每个星体 update
    //         for (int i=0;i<Planets.length;i++){
    //             Planets[i].update(dt,xForce[i],yForce[i]);
    //         }
    //         //绘制背景图
    //         StdDraw.picture(0,0,"images/starfield.jpg");
    //         //绘制每个星体的图片
    //         for (int i=0;i<Planets.length;i++){
    //             Planets[i].draw();
    //         }
    //         //显示屏幕外的缓冲区（双缓冲时动画在屏幕外）
    //         StdDraw.show();
    //         //暂停10毫秒
    //         StdDraw.pause(10);
    //     }
	}
  