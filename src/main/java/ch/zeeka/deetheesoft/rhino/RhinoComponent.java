package ch.zeeka.deetheesoft.rhino;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.core.math.Vec2;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class RhinoComponent extends Component {

    private int speed = 0;

    @Override
    public void onAdded() {
        entity.getTransformComponent().setScaleOrigin(entity.getCenter());
    }

    @Override
    public void onUpdate(double tpf) {

        Vec2 dir = Vec2.fromAngle(entity.getRotation() - 90)
                .mulLocal(speed);
        entity.translate(dir);

        if(speed != 0)
        {
            speed = (int)(speed*0.9);

            if(FXGLMath.abs(speed) < 1){
                speed = 0;
            }
        }
    }

    public void move()
    {
        speed = 10;
    }

    public void rotateLeft()
    {
        entity.rotateBy(-5);
    }

    public void rotateRight()
    {
        entity.rotateBy(5);
    }
}