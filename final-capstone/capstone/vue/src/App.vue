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
    background-color: rgb(31, 31, 56);
    padding: 10px;
    border-radius: 5px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    position: sticky; top: 0;
  }

  #nav button {
    border-radius: 7px;
    background-color: #9daac8;
    font-weight: bold;
  }

  #banner-logo-img {
    height: 50px;
    border-radius: 10px;
  }

  .links {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .centered-button {
    margin: 0 5px; /* Optional: Adjust the margin as needed */
    padding: 5px 10px;
    font-size: 14px;
  }

  .footer {
    background-color: rgb(31, 31, 56);
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