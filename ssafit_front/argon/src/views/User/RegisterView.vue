<template>
  <section class="section section-shaped section-lg my-0">
    <div class="shape shape-style-1 bg-gradient-default">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
    </div>
    <div class="container pt-lg-md">
      <div class="row justify-content-center">
        <div class="col-lg-5">
          <card type="secondary" shadow header-classes="bg-white pb-5" body-classes="px-lg-5 py-lg-5" class="border-0">
            <template>
              <div class="text-muted text-center mb-3">
                <small>회원가입</small>
              </div>

            </template>
            <template>

              <form role="form">
                <base-input alternative class="mb-3" placeholder="Name" addon-left-icon="ni ni-hat-3">
                </base-input>
                <base-input alternative class="mb-3" placeholder="Email" addon-left-icon="ni ni-email-83">
                </base-input>
                <base-input alternative type="password" placeholder="Password"
                  addon-left-icon="ni ni-lock-circle-open"></base-input>
                <base-input alternative class="mb-3" placeholder="Squat" addon-left-icon="ni ni-hat-3"></base-input>
                <base-input alternative class="mb-3" placeholder="Bench Press" addon-left-icon="ni ni-hat-3"></base-input>
                <base-input alternative class="mb-3" placeholder="Dead Lift" addon-left-icon="ni ni-hat-3"></base-input>
                <div class="row-lg-3 col-sm-6 mt-4 mt-md-0  ">
                    <!-- Radio buttons -->
                    <div class="mb-3">
                        <small class="text-uppercase font-weight-bold">성별</small>
                    </div>
                    <base-radio name="radio0" class="mb-3" >
                        남자
                    </base-radio>

                    <base-radio name="radio1" class="mb-3" >
                        여자
                    </base-radio>


                </div>

                <div class="text-muted font-italic">
                  <small>당신의 근육:
                    <span class="text-success font-weight-700">부족해</span>
                  </small>
                </div>
                <base-checkbox>
                  <span>매일 운동  <a href="#">하겠습니다</a>                  </span>
                </base-checkbox>
                <div class="text-center">
                  <base-button type="primary" class="my-4">계정 생성</base-button>
                </div>
              </form>
            </template>
          </card>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
export default {};
</script>
<style></style>
