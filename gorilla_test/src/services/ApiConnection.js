import axios from "axios";

const urlStore = "http://localhost:8080/stores";

const urlCharacteristic = "http://localhost:8080/characteristics";

const urlType = "http://localhost:8080/api/type";

const urlCity = "http://localhost:8080/api/cities";

const urlImage = "http://localhost:8080/images";

class ApiConnection 
{
  async getAllStores() {
    try {
      let response = await axios.get(urlStore);
      return response;
    } catch (error) {
      return error.message;
    }
  }

  async getStoreById(id) {
    try {
      let response = await axios.get(`${urlStore}/${id}`);
      return response;
    } catch (error) {
      return error.message;
    }
  }

  async deleteStoreById(id) {
    try {
      let response = await axios.delete(`${urlStore}/delete/${id}`);
      return response;
    } catch (error) {
      return error.message;
    }
  }

  async saveStore(store) {
    try {
      let response = await axios.post(urlStore, store);
      return response;
    } catch (error) {
      return error.message;
    }
  }

  async updateStore(id, store) {
    try {
      let response = await axios.put(`${urlStore}/update/${id}`, store);
      return response;
    } catch (error) {
      return error.message;
    }
  }

  async getCitiesInStore() 
  {
    try 
	{
		let response = await axios.get(`${urlStore}/cities`);
		return response;
    } 
	catch (error)
	{
		return error.message;
    }
  }

  async getTypesInStore() 
  {
    try 
	{
		let response = await axios.get(`${urlStore}/types`);
		return response;
    } 
	catch (error)
	{
		return error.message;
    }
  }

  async getAllCharacteristics() {
    try {
      let response = await axios.get(urlCharacteristic);
      return response;
    } catch (error) {
      return error.message;
    }
  }

  async getCharacteristicById(id) {
    try {
      let response = await axios.get(`${urlCharacteristic}/${id}`);
      return response;
    } catch (error) {
      return error.message;
    }
  }

  async deleteCharacteristicById(id) {
    try {
      let response = await axios.delete(`${urlCharacteristic}/delete/${id}`);
      return response;
    } catch (error) {
      return error.message;
    }
  }

  async saveCharacteristic(characteristic) {
    try {
      let response = await axios.post(urlCharacteristic, characteristic);
      return response;
    } catch (error) {
      return error.message;
    }
  }

  async updateCharacteristicById(id, characteristic) {
    try {
      let response = await axios.put(`${urlCharacteristic}/update/${id}`, characteristic);
      return response;
    } catch (error) {
      return error.message;
    }
  }

  async getAllTypes()
  {
	let response;
	try
	{
		response = await axios.get(urlType);

		return (response);
	}
	catch (error)
	{
		console.log(error.message);
	}
  }

  async getAllCities()
  {
	let response;
	try
	{
		response = await axios.get(urlCity);

		return (response);
	}
	catch (error)
	{
		console.log(error.message);
	}
  }

  async getImage(imageName)
  {
	let response;
	try
	{
		response = await axios.get(`${urlImage}/${imageName}`);

		return (response);
	}
	catch (error)
	{
		console.log(error.message);
	}
  }
}

export default new ApiConnection();