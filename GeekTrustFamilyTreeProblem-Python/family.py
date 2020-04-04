from person import Person
import custom_exceptions

class Family:
    family_members = []
    def __init__(self, head):
        self.head = head
        self.family_members.append(head)
    
    def search_member(self, name):
        for member in (self.family_members):
            if(member.name ==  name):
                return member
        raise custom_exceptions.PersonNotFound("PERSON NOT FOUND")
    

    '''
    Two ways to add members to family
    1) add_child
    2) add_spouse
    '''

    def add_child_in_family(self, mother, child):
        mother = Family.search_member(self, mother.name)
        if(mother.gender == "M"):
            raise custom_exceptions.ChildAdditionFailed("CHILD ADDITION FAILED")
        if(Person.get_spouse(mother) is None):
            raise custom_exceptions.ChildAdditionFailed("CHILD ADDITION FAILED")
        else:
            mother.add_children(child)
            mother.spouse.add_children(child)
            child.mother = mother
            child.father = mother.spouse
            self.family_members.append(child)
    
   
    def add_spouse_in_family(self, member, spouse):
        member = Family.search_member(self,member.name)
        member.add_spouse(spouse)
        spouse.add_spouse(member)
        self.family_members.append(spouse)

    
    def get_relationship(self, member, relation):
        if(relation == "Siblings"):
            result = Family.siblings(self, member)
        elif(relation == "Paternal-Uncle"):
            result = Family.uncle(self, member, "paternal")
        elif(relation == "Paternal-Aunt"):
            result = Family.aunt(self, member, "paternal")
        elif(relation == "Maternal-Uncle"):
            result = Family.uncle(self, member, "maternal")
        elif(relation == "Maternal-Aunt"):
            result = Family.aunt(self, member, "maternal")
        elif(relation == "Son"):
            result = Family.children(self, member, "son")
        elif(relation == "Daughter"):
            result = Family.children(self, member, "daughter")
        elif(relation == "Sister-In-Law"):
            result = Family.in_laws(self, member, "sister")
        elif(relation == "Brother-In-Law"):
            result = Family.in_laws(self, member, "brother")
        else:
            raise custom_exceptions.CommandNotFound("COMMAND NOT FOUND")
        return result

    '''
    All relations
    '''
    def children(self, name, gender):
        person = Family.search_member(self, name.name)
        if(gender == "daughter"):
            result = [per.name for per in person.daughters]
            if(result == []):
                raise custom_exceptions.NullPointer("NONE")
        else:
            result = [per.name for per in person.sons]
            if(result == []):
                raise custom_exceptions.NullPointer("NONE")
        return Family.in_order(self, result)

    def uncle(self, name, side):
        person = Family.search_member(self, name.name)
        if(side =="paternal"):
            result = [per.name for per in Person.get_paternal_uncle(person)]
            if(result == []):
                raise custom_exceptions.NullPointer("NONE")
        else:
            result = [per.name for per in Person.get_maternal_uncle(person)]
            if(result == []):
                raise custom_exceptions.NullPointer("NONE")
        return Family.in_order(self, result)

    def aunt(self, name, side):
        person = Family.search_member(self, name.name)
        if(side =="paternal"):
            result = [per.name for per in Person.get_paternal_aunt(person)]
            if(result == []):
                raise custom_exceptions.NullPointer("NONE")
        else:
            result = [per.name for per in Person.get_maternal_aunt(person)]
            if(result == []):
                raise custom_exceptions.NullPointer("NONE")
        return Family.in_order(self, result)

    def siblings(self, name):
        person = Family.search_member(self, name.name)
        result = [sibling.name for sibling in Person.get_brother(person)+ Person.get_sister(person)]
        if(result == []):
            raise custom_exceptions.NullPointer("NONE")
        return Family.in_order(self, result)

    def in_laws(self, name, side):
        person = Family.search_member(self, name.name)
        if(side == "sister"):
            result = [inlaw.name for inlaw in Person.get_sister_in_law(person)]
        else:
            result = [inlaw.name for inlaw in Person.get_brother_in_law(person)]
        return Family.in_order(self,result)
            

    '''
    Misc Functions
    '''
    def in_order(self, arr):
        result = []
        arr = [Family.search_member(self, arr[i]) for i in range(len(arr))]
        members = self.family_members
        for member in members:
            if(member in arr):
                result.append(member)
        result = [person.name for person in result]
        return result