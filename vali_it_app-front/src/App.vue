<template>
  <div id="app">

    <nav>
      <router-link to="/">Esileht</router-link> |
      <router-link to="/login">Logi sisse</router-link> |
      <router-link to="/user-page">User Page (ajutine)</router-link> |
      <router-link to="/company-page">Company Page (ajutine)</router-link>
      <button id="logout" type="button" class="btn btn-info btn-sm" v-on:click="navigateToHomePage()">Logi välja</button>
    </nav>
    <router-view/>

  </div>

</template>
<script>
export default {
  name: "SignUpView",


  data: function () {
    return {

    }

  },
  methods: {

    navigateToHomePage: function () {
      sessionStorage.clear()
      this.$router.push({name: 'home'})
    },

  },
}

</script>
<style>
#app {
  font-family: 'Poppins', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /*z-index: 1000;*/
}

nav {
  padding: 30px;
  background-color: #2c3e50;
}

nav a {
  font-weight: bold;
  color: #42b983;
}

nav a.router-link-exact-active {
  color: #42b983;
}
button {
  text-align: center;
  padding: 100px;
}
#logout {
  float: right;
}

</style>
