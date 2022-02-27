package com.jjh.study.stage.two;


//스킬트리
public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        // 예: skill: "CBD"
        // 스킬 트리 예시: "AECB"
        // CB만 sb.toString() 값이 될 것이고
        // skill 잘라서 비교하다보면 일치할 것이다.
        for(int i = 0; i < skill_trees.length; i++) {
            String skillTree = skill_trees[i];
            StringBuilder sb = new StringBuilder();
            //skill이 skillTree가 가진 스킬 셋을 포함하고 있으면 sb에 포함해준다.
            for(int j=0; j< skillTree.length(); j++){
                if(skill.contains(String.valueOf(skillTree.charAt(j)))){
                    sb.append(skillTree.charAt(j));
                }
            }
            //skill을 가장 긴 길이부터 잘라서 비교하면서 sb를 스트링으로 바꾼 값과 같은지 비교한다.
            for(int j=skill.length(); j>=0 ; j--){
                String str = skill.substring(0, j);
                if(str.equals(sb.toString())){
                    answer++;
                    break;
                }

            }
        }
        return answer;
    }
}
