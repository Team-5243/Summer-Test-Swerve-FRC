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
    BACK_LEFT(0, 1), BACK_RIGHT(2, 3), FRONT_LEFT(4, 5), FRONT_RIGHT(6, 7);

    private final TalonSRX spiny;
    private final Victor movy;
    private final int spinnyPort;
    private final int movyPort;

    DriveMotors(int spinnyPort, int movyPort) {
        this.spinnyPort = spinnyPort;
        this.movyPort = movyPort;

        spiny = new TalonSRX(getSpinnyPort());
        movy = new Victor(getMovyPort());
    }

    public TalonSRX getSpiny() {
        return spiny;
    }

    public Victor getMovy() {
        return movy;
    }

    public int getSpinnyPort() {
        return spinnyPort;
    }

    public int getMovyPort() {
        return movyPort;
    }
}
