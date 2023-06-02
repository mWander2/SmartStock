<template>
  <div class="home">
    <div class="header">
      <h1>Learning Today, Earning Tomorrow.</h1>
      <h2>Virtual Stock Empowers Investors through Education</h2>
    </div>
    <div class="link-container">
      <div class="link stock-link">
        <router-link v-bind:to="{name: ''}">
          <button class="link-btn">Search Stocks</button>
        </router-link>
      </div>
      <div class="link inner-link-container">
        <div class="game-link create-game">
          <router-link v-bind:to="{name: 'create-game'}">
            <button class="link-btn">Create Game</button>
          </router-link>
        </div>
        <div class="game-link my-games">
          <router-link v-bind:to="{name: 'my-games'}">
            <button class="link-btn">My Games</button>
          </router-link>
        </div>
      </div> 
      <button @click="showStockAnalysis">View All Stocks</button>
      <div v-if="showIframe">
        <iframe src="https://stockanalysis.com/stocks/" width="100%" height="500px"></iframe>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'home',
  data() {
    return {
      showIframe: false
    };
  },
  methods: {
    showStockAnalysis() {
      this.showIframe = true;
    }
  }
}
</script>

<style scoped>

.header {
  text-align: center;
  color: rgb(31, 31, 56);
  background-image: linear-gradient(to bottom right, #cff5ea, #9daac8);
  border-radius: 10px;
  border: 1px solid rgb(31, 31, 56);
  margin-top: -10px;
  margin-bottom: 10px;
}

.header h1 {
  margin-top: 7px;
}

.header h2 {
  font-size: 16px;
  font-style: italic;
  margin-top: -10px;
}

.link-container {
  display: flex;
  flex-direction: column;
  height: 85vh;
}

.link {
  border-radius: 10px;
  margin-bottom: 10px;
  height: 100%;
  opacity: 75%;
  
  display: flex;
  align-items: center;
  justify-content: center;
}

.stock-link {
  background-image: url("../../public/img/NavyAndBlueStock.png");
  background-size: cover;
  background-position: center;
  border: 1px solid rgb(31, 31, 56);
}

.inner-link-container {
  display: flex;
  /* background-image: linear-gradient(rgb(31, 31, 56), #cff5ea); */
  
  height: 75%;
  justify-content: space-around;
}

.game-link {
  background-color: black;
  height: 100%;
  width: 100%;
  border-radius: 5px;
  border: 1px solid rgb(31, 31, 56);

  display: flex;
  align-items: center;
  justify-content: center;
}

.create-game {
  background-image: url("../../public/img/CreateGame.jpg");
  background-size: cover;
  background-position: center;
  margin-right: 5px;
}

.my-games {
  background-image: url("../../public/img/MyGames.jpg");
  background-size: cover;
  background-position: center;
  margin-left: 5px;
}

.link-btn {
  background-color: #0078d0;
  border: 0;
  border-radius: 56px;
  color: #fff;
  cursor: pointer;
  display: inline-block;
  font-family: system-ui,-apple-system,system-ui,"Segoe UI",Roboto,Ubuntu,"Helvetica Neue",sans-serif;
  font-size: 18px;
  font-weight: 600;
  outline: 0;
  padding: 16px 21px;
  position: relative;
  text-align: center;
  text-decoration: none;
  transition: all .3s;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

.link-btn:before {
  background-color: initial;
  background-image: linear-gradient(#fff 0, rgba(255, 255, 255, 0) 100%);
  border-radius: 125px;
  content: "";
  height: 50%;
  left: 4%;
  opacity: .5;
  position: absolute;
  top: 0;
  transition: all .3s;
  width: 92%;
}

.link-btn:hover {
  box-shadow: rgba(255, 255, 255, .2) 0 3px 15px inset, rgba(0, 0, 0, .1) 0 3px 5px, rgba(0, 0, 0, .1) 0 10px 13px;
  transform: scale(1.05);
}

@media (min-width: 768px) {
  .link-btn {
    padding: 16px 48px;
  }

  .iframe-container {
  width: 100%;
  height: 500px;
  border: 1px solid #ccc;
  border-radius: 5px;
  overflow: hidden;
}

iframe {
  width: 100%;
  height: 100%;
  border: 2px solid black;
}

button {
   background-color: #0078d0;
  border: 0;
  border-radius: 56px;
  color: #fff;
  cursor: pointer;
  display: inline-block;
  font-family: system-ui,-apple-system,system-ui,"Segoe UI",Roboto,Ubuntu,"Helvetica Neue",sans-serif;
  font-size: 18px;
  font-weight: 600;
  outline: 0;
  padding: 16px 21px;
  position: relative;
  text-align: center;
  text-decoration: none;
  transition: all .3s;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

button:hover {
  box-shadow: rgba(255, 255, 255, .2) 0 3px 15px inset, rgba(0, 0, 0, .1) 0 3px 5px, rgba(0, 0, 0, .1) 0 10px 13px;
  transform: scale(1.05);
}
}
</style>
