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
}
  