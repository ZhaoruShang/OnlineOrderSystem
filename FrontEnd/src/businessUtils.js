export const getMyRestaurants = () => {
    return fetch("/business/restaurant").then((response) => {
      if (response.status !== 200) {
        throw Error("Fail to get restaurants");
      }
   
      return response.json();
    });
  };

  export const addRestaurant = (data) => {
    return fetch(`/business/restaurant`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: data,
      credentials: "include",
    }).then((response) => {
      if (response.status !== 201) {
        throw Error("Fail to add restaurant");
      }
    });
  };

  export const deleteRestaurant = (restaurantId) => {
    return fetch(`/business/restaurant/${restaurantId}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      credentials: "include",
    }).then((response) => {
      if (response.status !== 203) {
        throw Error("Fail to delete restaurant");
      }
    });
  };

  export const updateRestaurant = (data) => {
    return fetch(`/business/restaurant`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      body: data,
      credentials: "include",
    }).then((response) => {
      if (response.status !== 203) {
        throw Error("Fail to update restaurant");
      }
    });
  };

  export const getRestaurantMenu = (restaurantId) => {
    return fetch(`/business/restaurant/${restaurantId}/menu`).then((response) => {
      if (response.status !== 200) {
        throw Error("Fail to get menus");
      }
   
      return response.json();
    });
  };

  export const addRestaurantMenu = (restaurantId, data) => {
    return fetch(`/business/restaurant/${restaurantId}/menu`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: data,
      credentials: "include",
    }).then((response) => {
      if (response.status !== 201) {
        throw Error("Fail to add menu");
      }
    });
  };

  export const deleteRestaurant = (restaurantId, menuitemId) => {
    return fetch(`/business/restaurant/${restaurantId}/menu/{menuitemId}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      credentials: "include",
    }).then((response) => {
      if (response.status !== 203) {
        throw Error("Fail to delete restaurant");
      }
    });
  };

  export const updateRestaurant = (restaurantId, data) => {
    return fetch(`/business/restaurant/${restaurantId}/menu`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      body: data,
      credentials: "include",
    }).then((response) => {
      if (response.status !== 203) {
        throw Error("Fail to update restaurant");
      }
    });
  };