<template>
  <div>


    <body>
    <div class="container">
      <div class="d-flex justify-content-center h-100">
        <div class="card">
          <div class="card-header">
            <h3>Loo uus kasutaja</h3>
          </div>
          <div class="card-body">
            <form>
              <div class="input-group form-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-user">
                  <img class="ui-menu-icons" alt="email" src="../assets/email.png">
                  </i></span>
                </div>
                <input type="text" class="form-control" placeholder="e-mail" v-model="request.userName">

              </div>
              <div class="input-group form-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-key">

                    <img class="ui-menu-icons" alt="key" src="../assets/key.png">
                  </i></span>
                </div>
                <input type="password" class="form-control" placeholder="parool" v-model="request.password">
              </div>
              <div class="input-group form-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-key">

                    <img class="ui-menu-icons" alt="key" src="../assets/key.png">
                  </i></span>
                </div>
                <input type="password" class="form-control" placeholder="parool uuesti" v-model="passwordConfirm">
              </div>
              <div class="form-group">
                <label for="exampleFormControlSelect1">Vali roll</label>
                <select class="form-control" id="exampleFormControlSelect1" v-model="request.roleId">
                  <option selected v-for="role in roles" :value="role.id">{{ role.name }}</option>
                </select>
              </div>

              <div class="form-group">
                <input type="submit" value="Loo uus kasutaja" class="btn float-right login_btn"
                       v-on:click="addNewUser()">
              </div>
            </form>
          </div>
          <div class="card-footer">
            <!--            footeri tekst-->
          </div>
        </div>
      </div>
    </div>
    </body>
  </div>
</template>

<script>
export default {
  name: "SignUpView",

  data: function () {
    return {
      request: {},
      roles: {},
      passwordConfirm: null
    }

  },
  methods: {

    getAllRoles: function () {
      this.$http.get("/role/all")
          .then(response => {
            this.roles = response.data
            console.log(response.data)
          }).catch(error => {
        console.log(error)
      })
    },

    addNewUser: function () {

      if (this.request.password === this.passwordConfirm) {
        this.$http.post("/register/new", this.request
        ).then(response => {
          console.log(response.data)
        }).catch(error => {
          console.log(error)
        });
      } else {
        // todo viska teade, et parool ei klapi
        alert('parool ei klapi')
      }
    }

  },
  mounted() {
    this.getAllRoles()
  }
}

</script>

<style scoped>
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