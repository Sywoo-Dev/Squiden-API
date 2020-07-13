package fr.sywoo.api.account.particles;

public class DeathParticle {

	private String particleName, particleType;
	private float r, g, b;
	private int speed;
	
	public DeathParticle(String particleType, String enumName, int speed, float r, float g, float b) {
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

	public DeathParticle setParticleType(String particleType) {
		this.particleType = particleType;
		return this;
	}

	public String getParticleName() {
		return particleName;
	}

	public DeathParticle setParticleName(String particleName) {
		this.particleName = particleName;
		return this;
	}

	public int getSpeed() {
		return speed;
	}

	public DeathParticle setSpeed(int speed) {
		this.speed = speed;
		return this;
	}

	public float getR() {
		return r;
	}

	public DeathParticle setR(float r) {
		this.r = r;
		return this;
	}

	public float getG() {
		return g;
	}

	public DeathParticle setG(float g) {
		this.g = g;
		return this;
	}

	public float getB() {
		return b;
	}

	public DeathParticle setB(float b) {
		this.b = b;
		return this;
	}
}
