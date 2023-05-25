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
                          <base-button block type="warning" class=" mb-3" @click="deleteReviewModal(review)">삭제
                          </base-button>
                        </div>
                        <div v-else></div>
                          <base-button block type="primary" class=" mb-3" @click="updateReviewModal(review)">수정
                          </base-button>
                      </div>
                  </tab-pane>
              </card>
          </tabs>
      </div>

      <div class="col-md-4">
            <modal :show.sync="modals.modal1">
                <h6 slot="header" class="modal-title" id="modal-title-default">댓글 수정</h6>

                <p>내용 입력</p>
                    <form>
                      <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" v-model="updateContent" placeholder="내용을 입력해주세요..."></textarea>
                    </form>

                <template slot="footer">
                    <base-button type="primary" @click="updateReview">수정</base-button>
                    <base-button type="link" class="ml-auto" @click="modals.modal1 = false">취소
                    </base-button>
                </template>
            </modal>
        </div>
        <div class="col-md-4">
            <modal :show.sync="modals.modal2"
                   gradient="danger"
                   modal-classes="modal-danger modal-dialog-centered">
                <h6 slot="header" class="modal-title" id="modal-title-notification">댓글 삭제</h6>

                <div class="py-3 text-center">
                    <i class="ni ni-bell-55 ni-3x"></i>
                    <h4 class="heading mt-4">정말 댓글을 삭제하시겠습니까?</h4>
                    <p>댓글은 삭제 후 복구되지 않습니다!</p>
                </div>

                <template slot="footer">
                    <base-button type="white" @click="deleteReview">삭제</base-button>
                    <base-button type="link"
                                 text-color="white"
                                 class="ml-auto"
                                 @click="modals.modal2 = false">
                        취소
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
        modal3: false,
      },
      deleteTarget: {},
      updateTarget: {},
      updateContent: "",
    };
  },
  methods: {
    updateReviewModal(review) {
      this.updateTarget = review;
      this.modals.modal1 = true;
    },
    deleteReviewModal(review) {
      this.deleteTarget = review;
      this.modals.modal2 = true;
    },
    updateReview() {
      this.updateTarget.review_content = updateContent;
      this.$store.dispatch("updateReview", this.updateTarget);
      this.modals.modal1 = false;
    },
    deleteReview() {
      this.$store.dispatch("deleteReview", this.deleteTarget.review_id);
      this.modals.modal2 = false;
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
