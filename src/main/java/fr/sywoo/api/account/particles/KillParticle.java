package fr.sywoo.api.account.particles;

public class KillParticle {

	private String particleName, particleType;
	private float r, g, b;
	private int speed;
	
	public KillParticle(String particleType, String enumName, int speed, float r, float g, float b) {
		this.particleName = enumName;
		this.particleType = particleType;
		this.speed = speed;
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public String getParticleType() {
		return particleType;
	}

	public KillParticle setParticleType(String particleType) {
		this.particleType = particleType;
		return this;
	}

	public String getParticleName() {
		return particleName;
	}

	public KillParticle setParticleName(String particleName) {
		this.particleName = particleName;
		return this;
	}

	public int getSpeed() {
		return speed;
	}

	public KillParticle setSpeed(int speed) {
		this.speed = speed;
		return this;
	}

	public float getR() {
		return r;
	}

	public KillParticle setR(float r) {
		this.r = r;
		return this;
	}

	public float getG() {
		return g;
	}

	public KillParticle setG(float g) {
		this.g = g;
		return this;
	}

	public float getB() {
		return b;
	}

	public KillParticle setB(float b) {
		this.b = b;
		return this;
	}
}
