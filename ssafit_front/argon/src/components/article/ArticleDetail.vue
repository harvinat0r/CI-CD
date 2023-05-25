<template>
  <div class="row justify-content-center">
      <div class="col-lg-6 mt-5 mt-lg-0">
          <!-- Menu -->
          <div class="mb-3">
              <small class="text-uppercase font-weight-bold">제목 : {{ article.article_title }}</small>
          </div>
          <tabs fill class="flex-column flex-md-row">
              <card shadow>
                  <tab-pane title="내용">
                      <div class="description">{{ article.article_content }}</div>
                  </tab-pane>

                  <tab-pane title="댓글">
                      <div class="description" v-for="(review, index) in reviews" :key="index">
                        <div>
                          {{index}}번 댓글 :  {{ review.review_content }}
                        </div>
                        <div v-if="`${loginUser}` === `${review.user_id}`">
                          <base-button block type="warning" class=" mb-3" @click="modals.modal2 = true">삭제
                          </base-button>
                        </div>
                        <div v-else></div>
                        <div v-if="`${loginUser}` === `${review.user_id}`">
                          <base-button block type="primary" class=" mb-3" @click="modals.modal1 = true">수정
                          </base-button>
                        </div>
                        <div v-else></div>
                      </div>
                      
                  </tab-pane>
              </card>
          </tabs>
      </div>

      <div class="col-md-4">
            <modal :show.sync="modals.modal1">
                <h6 slot="header" class="modal-title" id="modal-title-default">Type your modal title</h6>

                <p>Far far away, behind the word mountains, far from the countries Vokalia and
                    Consonantia, there live the blind texts. Separated they live in Bookmarksgrove
                    right at the coast of the Semantics, a large language ocean.</p>
                <p>A small river named Duden flows by their place and supplies it with the necessary
                    regelialia. It is a paradisematic country, in which roasted parts of sentences
                    fly into your mouth.</p>

                <template slot="footer">
                    <base-button type="primary">Save changes</base-button>
                    <base-button type="link" class="ml-auto" @click="modals.modal1 = false">Close
                    </base-button>
                </template>
            </modal>
        </div>
        <div class="col-md-4">
            <modal :show.sync="modals.modal2"
                   gradient="danger"
                   modal-classes="modal-danger modal-dialog-centered">
                <h6 slot="header" class="modal-title" id="modal-title-notification">Your attention is required</h6>

                <div class="py-3 text-center">
                    <i class="ni ni-bell-55 ni-3x"></i>
                    <h4 class="heading mt-4">You should read this!</h4>
                    <p>A small river named Duden flows by their place and supplies it with the
                        necessary regelialia.</p>
                </div>

                <template slot="footer">
                    <base-button type="white">Ok, Got it</base-button>
                    <base-button type="link"
                                 text-color="white"
                                 class="ml-auto"
                                 @click="modals.modal2 = false">
                        Close
                    </base-button>
                </template>
            </modal>
        </div>
        <div class="col-md-4">
            <modal :show.sync="modals.modal3"
                   body-classes="p-0"
                   modal-classes="modal-dialog-centered modal-sm">
                <card type="secondary" shadow
                      header-classes="bg-white pb-5"
                      body-classes="px-lg-5 py-lg-5"
                      class="border-0">
                    <template>
                        <div class="text-muted text-center mb-3">
                            <small>Sign in with</small>
                        </div>
                        <div class="btn-wrapper text-center">
                            <base-button type="neutral">
                                <img slot="icon" src="img/icons/common/github.svg">
                                Github
                            </base-button>

                            <base-button type="neutral">
                                <img slot="icon" src="img/icons/common/google.svg">
                                Google
                            </base-button>
                        </div>
                    </template>
                    <template>
                        <div class="text-center text-muted mb-4">
                            <small>Or sign in with credentials</small>
                        </div>
                        <form role="form">
                            <base-input alternative
                                        class="mb-3"
                                        placeholder="Email"
                                        addon-left-icon="ni ni-email-83">
                            </base-input>
                            <base-input alternative
                                        type="password"
                                        placeholder="Password"
                                        addon-left-icon="ni ni-lock-circle-open">
                            </base-input>
                            <base-checkbox>
                                Remember me
                            </base-checkbox>
                            <div class="text-center">
                                <base-button type="primary" class="my-4">Sign In</base-button>
                            </div>
                        </form>
                    </template>
                </card>
            </modal>
        </div>
  </div>
</template>
<script>
import Tabs from "@/components/Tabs/Tabs.vue";
import TabPane from "@/components/Tabs/TabPane.vue";
import Modal from "@/components/Modal.vue";
import { mapState } from "vuex";
export default {
  components: {
    Tabs,
    TabPane,
    Modal,
  },
  name: "ArticleDetail",
  data() {
    return {
      modals: {
        modal1: false,
        modal2: false,
        modal3: false
      }
    };
  },
  methods: {
    updateUser() {
      this.$store.dispatch("updateUser", this.article);
    },
    deleteUser() {
      this.$store.dispatch("deleteUser", this.article.article_id);
    },
  },
  computed: {
    ...mapState(["article"]),
    ...mapState(["reviews"]),
    ...mapState(["loginUser"]),
  },
  created() {
    const pathName = new URL(document.location).href.split("/");
    const article_id = pathName[pathName.length - 1];
    console.log(new URL(document.location));
    this.$store.dispatch("setArticle", article_id);
    this.$store.dispatch("setArticleReviews", article_id);
  },
};
</script>
<style>
</style>
