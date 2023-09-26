package net.alchemycraft.libs.utils;

import net.minecraft.util.math.MathHelper;

public class TickTimer {
    private float progress;
    private float lastProgress;

    private float delta;

    private boolean active;
    private boolean complete;

    public TickTimer(int seconds) {
        this(1.0f / (float)(seconds * 20));
        // 1 sec - 20 ticks
        // n sec - n * 20 ticks
        // delta = 1 / (n * 20)
    }
    
    public TickTimer(float delta) {
        this.delta = delta;
    }

    public void start() {
        this.active = true;
        this.complete = false;
        this.progress = 0.0f;
    }

    public void step() {
        if (this.active) {
            this.lastProgress = this.progress;
            this.progress = Math.min(this.progress + delta, 1.0f);

            if (this.progress == 1.0f) {
                this.complete = true;
                this.active = false;
            }
        }
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public float getProgress() {
        return MathHelper.lerp(this.delta, this.lastProgress, this.progress);
    }
}
