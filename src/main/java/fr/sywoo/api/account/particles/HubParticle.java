package fr.sywoo.api.account.particles;

public class HubParticle {

	private String particleName, particleType;
	private float r, g, b;
	private int speed;
	private boolean onJoin;
	
	public HubParticle(String particleType, String enumName, int speed, float r, float g, float b, boolean onJoin) {
		this.particleName = enumName;
		this.particleType = particleType;
		this.speed = speed;
		this.r = r;
		this.g = g;
		this.b = b;
		this.onJoin = onJoin;
	}

	public String getParticleType() {
		return particleType;
	}

	public HubParticle setParticleType(String particleType) {
		this.particleType = particleType;
		return this;
	}

	public String getParticleName() {
		return particleName;
	}

	public HubParticle setParticleName(String particleName) {
		this.particleName = particleName;
		return this;
	}

	public int getSpeed() {
		return speed;
	}

	public HubParticle setSpeed(int speed) {
		this.speed = speed;
		return this;
	}

	public float getR() {
		return r;
	}

	public HubParticle setR(float r) {
		this.r = r;
		return this;
	}

	public float getG() {
		return g;
	}

	public HubParticle setG(float g) {
		this.g = g;
		return this;
	}

	public float getB() {
		return b;
	}

	public HubParticle setB(float b) {
		this.b = b;
		return this;
	}

	public boolean isOnJoin() {
		return onJoin;
	}

	public HubParticle setOnJoin(boolean onJoin) {
		this.onJoin = onJoin;
		return this;
	}
	
}
