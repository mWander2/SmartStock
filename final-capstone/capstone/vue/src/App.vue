<template>
  <div id="app">
    <div id="nav">
  
      <img id="banner-logo-img" src="../public/img/VirtualStock.png">
      <div class="links">
        <router-link v-bind:to="{ name: 'home' }">
          <button class="centered-button">Home</button>
        </router-link>&nbsp;&nbsp;
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">
          <button class="centered-button">Logout</button>
        </router-link>
      </div>
    </div>
    <router-view class="view"/>
    <div class="footer">
      &copy;
      <img id="footer-logo-img" src="../public/img/VirtualStock.png">
    </div>
  </div>
</template>

<style scoped>
  *, html {
    font-family: system-ui,-apple-system,system-ui,"Segoe UI",Roboto,Ubuntu,"Helvetica Neue",sans-serif;
  }

  #app {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 100vh;
  }

  #nav {
    margin-bottom: 20px;
    background-color: #072f50;
    padding: 1px;
    border-radius: 5px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    position: sticky; top: 0;
    background-color: #072f50;
  color: #fff;
  padding: 5px 5px;
  text-align: center;
  border-radius: 10px;
  margin-bottom: 5px;
  margin-top: -15px;
  }

  .logo {
    display: flex;
    align-items: center;
  }

  #banner-logo-img {
    height: 50px;
    border-radius: 10px;
    margin-right: 10px;
  }

  .links {
    display: flex;
    align-items: center;
  }

  .centered-button {
    margin: 0 5px; 
    padding: 5px 10px;
    font-size: 14px;
    background-color: transparent;
    border: none;
    color: white;
    font-weight: bold;
  }

  .centered-button:hover {
    background-color: rgba(255, 255, 255, 0.1);
  }

  .footer {
    background-color: #072f50;
    color: #cff5ea;
    display: flex;
    padding: 5px;
    border-radius: 5px;
  }

  #footer-logo-img {
    height: 20px;
    border-radius: 10px;
    margin-left: 5px;
  }
</style>