<template>
  <div class="login">
    <img alt="BCS_logo" src="../assets/BCS_logo.png">
    <body>
    <div class="container">
      <div class="d-flex justify-content-center h-100">
        <div class="card">
          <div class="card-header">
            <h3>Logi sisse</h3>
          </div>
          <div class="card-body">
            <form>
              <div class="input-group form-group">
                <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-user">
                  <img class="ui-menu-icons" alt="email" src="../assets/email.png">

                </i></span>
                </div>
                <input type="text" v-model="request.userName" class="form-control" placeholder="e-mail">

              </div>
              <div class="input-group form-group">
                <div class="input-group-prepend">
                <span class="input-group-text"><i class="fas fa-key">
                  <img class="ui-menu-icons" alt="key" src="../assets/key.png">

                </i></span>
                </div>
                <input type="password" v-model="request.password" class="form-control" placeholder="parool">
              </div>
              <div class="remember">
                <input type="checkbox"> Mäleta mind
              </div>
              <div class="form-group">
                <input type="submit" value="Logi sisse" class="btn float-right login_btn"
                       v-on:click="logIn(request.userName,request.password)">
              </div>
            </form>
          </div>
          <div class="card-footer">
            <div class="create-user">
              Pole veel kasutajat? <a href="#" v-on:click="navigateToSignUp()">Loo kasutaja</a>
            </div>
            <div class="d-flex justify-content-center">
              <a href="#">Unustasid parooli?</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    </body>
  </div>
</template>

<script>
export default {
  name: "LoginView",

  data: function () {
    return {
      request: {},
      userId: 0,
      roleId: 0

    }
  },
  methods: {
    saveDataToSessionStorage: function () {
      sessionStorage.setItem('userId', this.userId )
      sessionStorage.setItem('roleId', this.roleId )
    },
    navigateToSignUp: function () {
      this.$router.push({name: 'sign-up'})
    },
    navigateToUserPage: function () {
      this.$router.push({name: 'user-page'})
    },

    logIn: function (userName, password) {
      this.$http.get("/login/in",{
        params:{
          userName: userName,
          password: password
        }
      })
          .then(response => {
            this.request = response.data
            this.userId = response.data.userId
            this.roleId = response.data.roleId
            this.saveDataToSessionStorage()
            this.navigateToUserPage()
            console.log(response.data)
          }).catch(error => {
        alert(error.response.data.detail)
        console.log(error)
      })

    }


  }
}
</script>

<style scoped>
img {
  width: 25vw;
  height: auto;
}

.ui-menu-icons {
  width: 18px;
  height: auto;

}

.login_btn {
  background-color: blue;
  color: white;
}

.login_btn:hover {
  color: white;
  background-color: deepskyblue;
}

</style>