package projectZero;

public class Bicycle {
		private int id;
		private String brand;
		private String model;
		private String weight;
		private String speed;
		private String color;
		private String status;
		
		public Bicycle() {
			id = 0;
			brand = "colnago";
			model = "classic arabesque";
			weight = "50 lbs";
			speed = "30 mph";
			color = "red";
			status = "available";
		}

		public int getId() {
			return id;
		}

		public void setId(int Id) {
			this.id = Id;
		}
		
		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getWeight() {
			return weight;
		}

		public void setWeight(String weight) {
			this.weight = weight;
		}
		public String getSpeed() {
			return speed;
		}
		public void setSpeed(String speed) {
			this.speed = speed;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((brand == null) ? 0 : brand.hashCode());
			result = prime * result + ((model == null) ? 0 : model.hashCode());
			result = prime * result + ((weight == null) ? 0 : weight.hashCode());
			result = prime * result + ((speed == null) ? 0 : speed.hashCode());
			result = prime * result + ((color == null) ? 0 : color.hashCode());
			result = prime * result + ((status == null) ? 0 : status.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Bicycle other = (Bicycle) obj;
			if (id != other.id)
				return false;			
			if (brand == null) {
				if (other.brand != null)
					return false;
			} else if (!brand.equals(other.brand))
				return false;
			if (model == null) {
				if (other.model != null)
					return false;
			} else if (!model.equals(other.model))
				return false;
			if (weight == null) {
				if (other.weight != null)
					return false;
			} else if (!weight.equals(other.weight))
				return false;
			if (speed == null) {
				if (other.speed !=null)
					return false;
			} else if (!speed.equals(other.speed))
				return false;
			if (color == null) {
				if (other.color != null)
					return false;
			} else if (!color.equals(other.color))
				return false;
			if (status == null) {
				if (other.status != null)
					return false;
			} else if (!status.equals(other.status))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Bicycle [bikeId=" + id + ", brand=" + brand + " , model=" + model + 
					", weight=" + weight + ", speed=" + speed + ", color=" + color + ", status=" + status + "]";
		}
	}



