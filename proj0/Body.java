public class Body{
    public double xxPos, yyPos;
    public double xxVel, yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV, double yV,double m,String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
        double dx = xxPos - b.xxPos;
        double dy = yyPos - b.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Body b){
            double G = 6.67e-11;
            double dis = this.calcDistance(b);
            return G*mass*b.mass/(dis*dis);
    }
    
    public double calcForceExertedByX(Body b){
        double F = calcForceExertedBy(b);
        double dis = calcDistance(b);
        return F*(b.xxPos - xxPos)/dis;
    }

    public double calcForceExertedByY(Body b){
        double F = calcForceExertedBy(b);
        double dis = calcDistance(b);
        return F*(b.yyPos - yyPos)/dis;
    }

    public double calcNetForceExertedByX(Body[] bodys){
        double Fx= 0;
        for(Body body : bodys){
            if(!this.equals(body)){
                Fx += calcForceExertedByX(body);
            }
        }
        return Fx;
    }

    public double calcNetForceExertedByY(Body[] bodys){
        double Fy= 0;
        for(Body body : bodys){
            if(!this.equals(body)){
                Fy += calcForceExertedByY(body);
            }
        }
        return Fy;
    }

    public void update(double dt,double Fx,double Fy){
        double ax = Fx/mass;
        double ay = Fy/mass;
        xxVel += dt*ax;
        yyVel += dt*ay;
        xxPos += dt*xxVel;
        yyPos += dt*yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images/" + imgFileName);
    }
}