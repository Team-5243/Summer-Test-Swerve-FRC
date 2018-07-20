/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team5243;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Victor;

public enum DriveMotors {
    BACK_LEFT(0, 1, true), BACK_RIGHT(2, 3, false), FRONT_LEFT(4, 5, false), FRONT_RIGHT(6, 7, false);

    private final TalonSRX spiny;
    private final TalonSRX movyTalon; //This is used only for one of the motors as a replacement for a Victor
    private final Victor movy;
    private final int spinnyPort;
    private final int movyPort;

    DriveMotors(int spinnyPort, int movyPort, boolean dualTalons) {
        this.spinnyPort = spinnyPort;
        this.movyPort = movyPort;

        spiny = new TalonSRX(getSpinnyPort());

        if (dualTalons) {
            movyTalon = new TalonSRX(getMovyPort());
            movy = null;
        } else {
            movyTalon = null;
            movy = new Victor(getMovyPort());
        }
    }

    public TalonSRX getSpiny() {
        return spiny;
    }

    //NOTE: The returned value must be casted to be fully used
    public Object getMovy() {
        return movy != null ? movy : movyTalon;
    }

    public int getSpinnyPort() {
        return spinnyPort;
    }

    public int getMovyPort() {
        return movyPort;
    }
}
